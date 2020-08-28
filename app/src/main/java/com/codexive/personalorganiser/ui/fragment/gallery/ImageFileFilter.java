package com.codexive.personalorganiser.ui.fragment.gallery;

import java.io.File;
import java.io.FileFilter;

public class ImageFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else if (isImageFile(file.getAbsolutePath())) {
            return true;
        }
        return false;
    }

    private boolean isImageFile(String filePath) {
        if (filePath.endsWith(".jpg") || filePath.endsWith(".png"))
        // Add other formats as desired
        {
            return true;
        }
        return false;
    }
}
