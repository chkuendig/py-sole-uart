"""Tests for device discovery."""

import pytest
from unittest.mock import MagicMock
from sole_uart.const import FTMS_SERVICE, MICROCHIP_COMPANY_ID, SOLE_UART_SERVICE
from sole_uart.discovery import has_sole_uart_service, is_sole_device


class TestIsSoleDevice:
    """Test is_sole_device function."""

    def test_detect_by_microchip_manufacturer_id(self):
        """Test detection via Microchip manufacturer ID."""
        device = MagicMock()
        device.name = "Unknown"
        device.address = "AA:BB:CC:DD:EE:FF"

        adv_data = {
            "manufacturer_data": {MICROCHIP_COMPANY_ID: b"\x00\x01"}
        }

        assert is_sole_device(device, adv_data) is True

    def test_detect_by_device_name_f65(self):
        """Test detection via F65 device name."""
        device = MagicMock()
        device.name = "F65"
        device.address = "AA:BB:CC:DD:EE:FF"

        assert is_sole_device(device, None) is True

    def test_detect_by_device_name_f80(self):
        """Test detection via F80 device name."""
        device = MagicMock()
        device.name = "F80"
        device.address = "AA:BB:CC:DD:EE:FF"

        assert is_sole_device(device, None) is True

    def test_detect_by_device_name_tt8(self):
        """Test detection via TT8 device name."""
        device = MagicMock()
        device.name = "TT8"
        device.address = "AA:BB:CC:DD:EE:FF"

        assert is_sole_device(device, None) is True

    def test_detect_by_device_name_e25(self):
        """Test detection via E25 device name (elliptical)."""
        device = MagicMock()
        device.name = "E25"
        device.address = "AA:BB:CC:DD:EE:FF"

        assert is_sole_device(device, None) is True

    def test_detect_by_ftms_service(self):
        """Test detection via FTMS service advertisement."""
        device = MagicMock()
        device.name = "Unknown"
        device.address = "AA:BB:CC:DD:EE:FF"

        adv_data = {
            "service_uuids": [FTMS_SERVICE]
        }

        assert is_sole_device(device, adv_data) is True

    def test_no_detection_generic_device(self):
        """Test that generic devices are not detected."""
        device = MagicMock()
        device.name = "GenericDevice"
        device.address = "AA:BB:CC:DD:EE:FF"

        adv_data = {
            "manufacturer_data": {0x004C: b"\x00\x01"}  # Apple
        }

        assert is_sole_device(device, adv_data) is False

    def test_no_detection_no_data(self):
        """Test no detection with no advertisement data."""
        device = MagicMock()
        device.name = None
        device.address = "AA:BB:CC:DD:EE:FF"

        assert is_sole_device(device, None) is False


class TestHasSoleUartService:
    """Test has_sole_uart_service function."""

    def test_has_both_services(self):
        """Test device with both FTMS and Sole UART."""
        service_uuids = [
            FTMS_SERVICE,
            SOLE_UART_SERVICE,
            "00001800-0000-1000-8000-00805f9b34fb",  # Generic Access
        ]
        assert has_sole_uart_service(service_uuids) is True

    def test_has_only_ftms(self):
        """Test device with only FTMS (not a Sole)."""
        service_uuids = [
            FTMS_SERVICE,
            "00001800-0000-1000-8000-00805f9b34fb",
        ]
        assert has_sole_uart_service(service_uuids) is False

    def test_has_only_uart(self):
        """Test device with only UART (shouldn't happen but test anyway)."""
        service_uuids = [
            SOLE_UART_SERVICE,
            "00001800-0000-1000-8000-00805f9b34fb",
        ]
        assert has_sole_uart_service(service_uuids) is False

    def test_has_neither_service(self):
        """Test device with neither service."""
        service_uuids = [
            "00001800-0000-1000-8000-00805f9b34fb",
            "0000180a-0000-1000-8000-00805f9b34fb",
        ]
        assert has_sole_uart_service(service_uuids) is False

    def test_case_insensitive(self):
        """Test that service UUID comparison is case-insensitive."""
        service_uuids = [
            FTMS_SERVICE.upper(),
            SOLE_UART_SERVICE.lower(),
        ]
        assert has_sole_uart_service(service_uuids) is True
