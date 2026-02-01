package com.android.utils;

import com.google.common.io.Closeables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class GrabProcessOutput {

    public interface IProcessOutput {
        void err(String line);

        void out(String line);
    }

    public enum Wait {
        ASYNC,
        WAIT_FOR_PROCESS,
        WAIT_FOR_READERS
    }

    public static int grabProcessOutput(final Process process, Wait waitMode, final IProcessOutput output) throws InterruptedException {
        Thread thread = new Thread("stderr") { // from class: com.android.utils.GrabProcessOutput.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String line;
                InputStream errorStream = process.getErrorStream();
                InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                do {
                    try {
                        try {
                            line = bufferedReader.readLine();
                            IProcessOutput iProcessOutput = output;
                            if (iProcessOutput != null) {
                                iProcessOutput.err(line);
                            }
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        Closeables.close(errorStream, true);
                    } catch (Throwable th) {
                        try {
                            Closeables.close(errorStream, true);
                        } catch (IOException unused3) {
                        }
                        try {
                            Closeables.close(inputStreamReader, true);
                        } catch (IOException unused4) {
                        }
                        try {
                            Closeables.close(bufferedReader, true);
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                } while (line != null);
                Closeables.close(errorStream, true);
                try {
                    Closeables.close(inputStreamReader, true);
                } catch (IOException unused6) {
                }
                try {
                    Closeables.close(bufferedReader, true);
                } catch (IOException unused7) {
                }
            }
        };
        Thread thread2 = new Thread("stdout") { // from class: com.android.utils.GrabProcessOutput.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String line;
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                do {
                    try {
                        try {
                            line = bufferedReader.readLine();
                            IProcessOutput iProcessOutput = output;
                            if (iProcessOutput != null) {
                                iProcessOutput.out(line);
                            }
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        Closeables.close(inputStream, true);
                    } catch (Throwable th) {
                        try {
                            Closeables.close(inputStream, true);
                        } catch (IOException unused3) {
                        }
                        try {
                            Closeables.close(inputStreamReader, true);
                        } catch (IOException unused4) {
                        }
                        try {
                            Closeables.close(bufferedReader, true);
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                } while (line != null);
                Closeables.close(inputStream, true);
                try {
                    Closeables.close(inputStreamReader, true);
                } catch (IOException unused6) {
                }
                try {
                    Closeables.close(bufferedReader, true);
                } catch (IOException unused7) {
                }
            }
        };
        thread.setContextClassLoader(null);
        thread2.setContextClassLoader(null);
        thread.start();
        thread2.start();
        if (waitMode == Wait.ASYNC) {
            return 0;
        }
        if (waitMode == Wait.WAIT_FOR_READERS) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            try {
                thread2.join();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
        return process.waitFor();
    }
}
