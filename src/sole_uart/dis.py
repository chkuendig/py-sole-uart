"""
Standard BLE Device Information Service (DIS) support.

The Device Information Service (0x180A) is a standard BLE service that
provides manufacturer info, model numbers, serial numbers, and version info.
"""

import logging
from dataclasses import dataclass
from typing import Optional

from bleak import BleakClient

_LOGGER = logging.getLogger(__name__)

DIS_UUID = "180a"
"""Device Information Service UUID"""

_CHARACTERISTICS_MAP = {
    "manufacturer": "2a29",
    "model": "2a24",
    "serial_number": "2a25",
    "sw_version": "2a28",
    "hw_version": "2a27",
    "fw_version": "2a26",
}


@dataclass
class BLEDeviceInfo:
    """Standard BLE Device Information from DIS."""

    manufacturer: Optional[str] = None
    """Manufacturer name"""

    model: Optional[str] = None
    """Model number"""

    serial_number: Optional[str] = None
    """Serial number"""

    sw_version: Optional[str] = None
    """Software version"""

    hw_version: Optional[str] = None
    """Hardware version"""

    fw_version: Optional[str] = None
    """Firmware version"""


async def read_device_info(client: BleakClient) -> BLEDeviceInfo:
    """
    Read Device Information Service (DIS).

    Args:
        client: Connected BleakClient

    Returns:
        BLEDeviceInfo with available fields populated
    """
    _LOGGER.debug("Reading Device Information Service (0x180A)...")

    result = BLEDeviceInfo()

    # Try to get the DIS service
    if srv := client.services.get_service(DIS_UUID):
        for field_name, char_uuid in _CHARACTERISTICS_MAP.items():
            if char := srv.get_characteristic(char_uuid):
                try:
                    data = await client.read_gatt_char(char)
                    value = data.decode('utf-8').strip('\x00')
                    setattr(result, field_name, value)
                    _LOGGER.debug(f"  {field_name}: '{value}'")
                except Exception as e:
                    _LOGGER.debug(f"  {field_name}: <error: {e}>")
    else:
        _LOGGER.debug("Device Information Service not found")

    # Use fw_version as sw_version fallback if sw_version is missing/placeholder
    sw = result.sw_version or ""
    fw = result.fw_version or ""
    is_placeholder = lambda v: not v or v.strip("0") == ""

    if is_placeholder(sw) and not is_placeholder(fw):
        result.sw_version = fw
        _LOGGER.debug(f"  Using fw_version as sw_version: '{fw}'")

    return result
