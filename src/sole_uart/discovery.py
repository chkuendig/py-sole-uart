"""Device discovery utilities for Sole treadmills."""

import logging
from typing import Optional

from bleak import BleakScanner
from bleak.backends.device import BLEDevice

from .const import (
    FTMS_SERVICE,
    MICROCHIP_COMPANY_ID,
    SOLE_NAME_PREFIXES,
    SOLE_UART_SERVICE,
)

_LOGGER = logging.getLogger(__name__)


def is_sole_device(
    device: BLEDevice,
    advertisement_data: Optional[dict] = None,
) -> bool:
    """
    Detect if a device is likely a Sole treadmill.

    Before connection (advertisement data only):
    - Checks for Microchip manufacturer ID (0x0157)
    - Checks device name prefixes (F63, F65, F80, etc.)

    After connection (service discovery):
    - Checks for both FTMS and Sole UART services

    Args:
        device: BLE device
        advertisement_data: Optional advertisement data with manufacturer info

    Returns:
        True if device appears to be a Sole treadmill
    """
    # Check manufacturer data if available
    if advertisement_data and "manufacturer_data" in advertisement_data:
        manufacturer_data = advertisement_data["manufacturer_data"]
        if MICROCHIP_COMPANY_ID in manufacturer_data:
            _LOGGER.debug(f"Device {device.address} has Microchip manufacturer ID")
            return True

    # Check device name
    if device.name:
        for prefix in SOLE_NAME_PREFIXES:
            if device.name.startswith(prefix):
                _LOGGER.debug(f"Device {device.address} name matches: {device.name}")
                return True

    # Check advertised services if available
    if advertisement_data and "service_uuids" in advertisement_data:
        service_uuids = [s.lower() for s in advertisement_data["service_uuids"]]
        # Sole devices advertise FTMS service
        if FTMS_SERVICE.lower() in service_uuids:
            _LOGGER.debug(f"Device {device.address} advertises FTMS service")
            return True

    return False


def has_sole_uart_service(service_uuids: list[str]) -> bool:
    """
    Check if device has Sole UART service (after connection).

    This is the most reliable detection method but requires
    connection and service discovery.

    Args:
        service_uuids: List of service UUIDs from GATT discovery

    Returns:
        True if Sole UART service is present
    """
    uuids_lower = [s.lower() for s in service_uuids]
    has_ftms = FTMS_SERVICE.lower() in uuids_lower
    has_uart = SOLE_UART_SERVICE.lower() in uuids_lower

    # Device with both FTMS and Sole UART = Sole/Dyaco treadmill
    return has_ftms and has_uart


async def find_sole_device(
    timeout: float = 10.0,
    address: Optional[str] = None,
) -> Optional[BLEDevice]:
    """
    Scan for Sole treadmill devices.

    Args:
        timeout: Scan timeout in seconds
        address: Optional specific device address to find

    Returns:
        First discovered Sole device or None if not found
    """
    _LOGGER.info(f"Scanning for Sole devices (timeout={timeout}s)...")

    if address:
        _LOGGER.info(f"Looking for specific device: {address}")
        device = await BleakScanner.find_device_by_address(
            address,
            timeout=timeout,
        )
        if device:
            _LOGGER.info(f"Found device: {device.name} ({device.address})")
            return device
        _LOGGER.warning(f"Device {address} not found")
        return None

    # Scan for any Sole device
    devices = await BleakScanner.discover(timeout=timeout)

    for device in devices:
        if is_sole_device(device):
            _LOGGER.info(f"Found Sole device: {device.name} ({device.address})")
            return device

    _LOGGER.warning("No Sole devices found")
    return None
