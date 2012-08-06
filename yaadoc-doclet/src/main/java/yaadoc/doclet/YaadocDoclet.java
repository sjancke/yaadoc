package yaadoc.doclet;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.sun.javadoc.*;

public class YaadocDoclet {
	public static LanguageVersion languageVersion() {
		return LanguageVersion.JAVA_1_5;
	}

	public static int optionLength(String option) {
		return 0;
	}

	public static boolean start(RootDoc root) {
		StringBuilder classes = new StringBuilder();
		
		for(ClassDoc documentedClass : root.classes()) {
			classes.append("Class: " + documentedClass.qualifiedName());
			classes.append("  " + documentedClass.commentText());
		}
		
		try {
			Files.write(classes.toString(), new File("classes.html"), Charsets.UTF_8);
				return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static boolean validOptions(String[][] options, DocErrorReporter reporter) {
		return true;
	}
}
