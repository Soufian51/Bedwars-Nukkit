// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.map;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;

import Steffen.bedwars.Bedwars;

import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import cn.nukkit.Server;
import java.io.IOException;
import java.io.File;

public class Reset
{
    public Reset(final String mapname) {
        try {
            copy(new File(Bedwars.getInstance().getDataFolder() + "/map/" + mapname), new File(Bedwars.getInstance().getServer().getDataPath() + "worlds/" + mapname));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Server.getInstance().loadLevel(mapname);
    }
    
    @Deprecated
    public static void deleteFileOrFolder(final Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult visitFileFailed(final Path file, final IOException e) {
                return this.handleException(e);
            }
            
            private FileVisitResult handleException(final IOException e) {
                e.printStackTrace();
                return FileVisitResult.TERMINATE;
            }
            
            @Override
            public FileVisitResult postVisitDirectory(final Path dir, final IOException e) throws IOException {
                if (e != null) {
                    return this.handleException(e);
                }
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    
    private static void copy(final File sourceLocation, final File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        }
        else {
            copyFile(sourceLocation, targetLocation);
        }
    }
    
    private static void copyDirectory(final File source, final File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }
        for (final String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }
    
    private static void copyFile(final File source, final File target) throws IOException {
        final InputStream in = new FileInputStream(source);
        try {
            final OutputStream out = new FileOutputStream(target);
            try {
                final byte[] buf = new byte[1024];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
                out.close();
            }
            catch (Throwable t) {
                try {
                    out.close();
                }
                catch (Throwable exception) {
                    t.addSuppressed(exception);
                }
                throw t;
            }
            in.close();
        }
        catch (Throwable t2) {
            try {
                in.close();
            }
            catch (Throwable exception2) {
                t2.addSuppressed(exception2);
            }
            throw t2;
        }
    }
}
