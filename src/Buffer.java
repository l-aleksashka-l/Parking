
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class Buffer {
    public Buffer() {
    }

    static byte[] toByteArray(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        Throwable throwable1 = null;

        Object o;
        try {
            zipOutputStream.putNextEntry(new ZipEntry("r"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream);
            Throwable throwable = null;

            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                zipOutputStream.closeEntry();
                zipOutputStream.flush();
                o = byteArrayOutputStream.toByteArray();
            } catch (Throwable throwable2) {
                o = throwable2;
                throwable = throwable2;
                throw throwable2;
            } finally {
                if (objectOutputStream != null) {
                    if (throwable != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    } else {
                        objectOutputStream.close();
                    }
                }

            }
        } catch (Throwable throwable) {
            throwable1 = throwable;
            throw throwable;
        } finally {
            if (zipOutputStream != null) {
                if (throwable1 != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable throwable) {
                        throwable1.addSuppressed(throwable);
                    }
                } else {
                    zipOutputStream.close();
                }
            }

        }

        return (byte[])o;
    }

    static Object fromByteArray(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
        Throwable throwable = null;

        Object o;
        try {
            zipInputStream.getNextEntry();
            ObjectInputStream objectInputStream = new ObjectInputStream(zipInputStream);
            Throwable throwable1 = null;

            try {
                o = objectInputStream.readObject();
            } catch (Throwable throwable2) {
                o = throwable2;
                throwable1 = throwable2;
                throw throwable2;
            } finally {
                if (objectInputStream != null) {
                    if (throwable1 != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable throwable2) {
                            throwable1.addSuppressed(throwable2);
                        }
                    } else {
                        objectInputStream.close();
                    }
                }

            }
        } catch (Throwable throwable1) {
            throwable = throwable1;
            throw throwable1;
        } finally {
            if (zipInputStream != null) {
                if (throwable != null) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                } else {
                    zipInputStream.close();
                }
            }

        }

        return o;
    }

    public static long writeObject(RandomAccessFile randomAccessFile, Serializable serializable) throws IOException {
        long length = randomAccessFile.length();
        randomAccessFile.seek(length);
        byte[] bytes = toByteArray(serializable);
        randomAccessFile.writeInt(bytes.length);
        randomAccessFile.write(bytes);
        randomAccessFile.setLength(randomAccessFile.getFilePointer());
        return length;
    }

    public static Object readObject(RandomAccessFile randomAccessFile, long l) throws IOException, ClassNotFoundException {
        randomAccessFile.seek(l);
        int readInt = randomAccessFile.readInt();
        byte[] bytes = new byte[readInt];
        randomAccessFile.read(bytes);
        return fromByteArray(bytes);
    }
}

