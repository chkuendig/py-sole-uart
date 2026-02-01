package com.android.ddmlib.internal.commands;

import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.DeviceMonitor;

/* loaded from: classes3.dex */
public class DisconnectCommand implements ICommand {
    public static final String COMMAND = "disconnect";
    private DeviceMonitor myMonitor;

    public DisconnectCommand(DeviceMonitor monitor) {
        this.myMonitor = monitor;
    }

    @Override // com.android.ddmlib.internal.commands.ICommand
    public CommandResult run(String argsString) throws NumberFormatException {
        try {
            if (argsString == null) {
                throw new IllegalArgumentException("Expected arguments got null.");
            }
            String[] strArrSplit = argsString.split(":");
            if (strArrSplit.length != 2) {
                throw new IllegalArgumentException("Expected 2 parameters got " + strArrSplit.length);
            }
            String str = strArrSplit[0];
            int i = Integer.parseInt(strArrSplit[1]);
            for (IDevice iDevice : this.myMonitor.getDevices()) {
                if (iDevice.getSerialNumber().equals(str)) {
                    this.myMonitor.disconnectClient(iDevice, i);
                    return new CommandResult();
                }
            }
            Log.w("DisconnectCommand", "No client found for given args (" + argsString + ")");
            return new CommandResult("No client found for " + argsString);
        } catch (Exception e) {
            Log.e("DisconnectCommand", e);
            return new CommandResult("Unknown error: " + e.getMessage());
        }
    }
}
