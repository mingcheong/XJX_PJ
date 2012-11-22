package com;

import com.safetys.framework.generator.GeneratorFile;

public class BuilderModel {

	public static void main(String[] args) throws Exception {
		GeneratorFile file = new GeneratorFile();
		file.generateCRUDByAllTable();
	}
}
