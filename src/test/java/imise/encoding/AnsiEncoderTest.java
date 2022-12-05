package imise.encoding;

import org.junit.Assert;
import org.junit.Test;

public class AnsiEncoderTest {

	@Test
	public void testReplaceAllAnsi() {
		String in = "f�r einen test mit ��� und ��� und � und weiteren kritischen � � Zeichen @ �";
		String out = AnsiEncoder.replaceAllAnsi(in);
		System.out.println(in);
		System.out.println(out);
		Assert.assertTrue(out.contains("&#252;"));
	}

}
