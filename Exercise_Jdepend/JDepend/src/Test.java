import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jdepend.xmlui.JDepend;

public class Test {
	public static void main(String[] args) throws IOException {
		JDepend jp = new JDepend(new PrintWriter(new FileWriter("src\\reportxml\\report.xml")));
		jp.addDirectory("E:\\js\\Library-Assistant-master");
		jp.analyze();
	}
}
