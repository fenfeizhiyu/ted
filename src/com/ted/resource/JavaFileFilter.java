package com.ted.resource;

import java.io.File;

public class JavaFileFilter implements FileFilter{

	@Override
	public boolean accept(File file) {
		return file.getName().endsWith(".java");
	}

	
}
