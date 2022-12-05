package imise.encoding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnsiEncoder {

	static Map<String, String> ansiMap = new HashMap<String, String>();
	static {
		ansiMap.put("�", "&#128;");
		ansiMap.put("�", "&#130;");
		ansiMap.put("�", "&#131;");
		ansiMap.put("�", "&#132;");
		ansiMap.put("�", "&#133;");
		ansiMap.put("�", "&#134;");
		ansiMap.put("�", "&#135;");
		ansiMap.put("�", "&#136;");
		ansiMap.put("�", "&#137;");
		ansiMap.put("�", "&#138;");
		ansiMap.put("�", "&#139;");
		ansiMap.put("�", "&#140;");
		ansiMap.put("�", "&#142;");
		ansiMap.put("�", "&#145;");
		ansiMap.put("�", "&#146;");
		ansiMap.put("�", "&#147;");
		ansiMap.put("�", "&#148;");
		ansiMap.put("�", "&#149;");
		ansiMap.put("�", "&#150;");
		ansiMap.put("�", "&#151;");
		ansiMap.put("�", "&#152;");
		ansiMap.put("�", "&#153;");
		ansiMap.put("�", "&#154;");
		ansiMap.put("�", "&#155;");
		ansiMap.put("�", "&#156;");
		ansiMap.put("�", "&#158;");
		ansiMap.put("�", "&#159;");
		ansiMap.put("�", "&#161;");
		ansiMap.put("�", "&#162;");
		ansiMap.put("�", "&#163;");
		ansiMap.put("�", "&#164;");
		ansiMap.put("�", "&#165;");
		ansiMap.put("�", "&#166;");
		ansiMap.put("�", "&#167;");
		ansiMap.put("�", "&#168;");
		ansiMap.put("�", "&#169;");
		ansiMap.put("�", "&#170;");
		ansiMap.put("�", "&#171;");
		ansiMap.put("�", "&#172;");
		ansiMap.put("�", "&#173;");
		ansiMap.put("�", "&#174;");
		ansiMap.put("�", "&#175;");
		ansiMap.put("�", "&#176;");
		ansiMap.put("�", "&#177;");
		ansiMap.put("�", "&#178;");
		ansiMap.put("�", "&#179;");
		ansiMap.put("�", "&#180;");
		ansiMap.put("�", "&#181;");
		ansiMap.put("�", "&#182;");
		ansiMap.put("�", "&#183;");
		ansiMap.put("�", "&#184;");
		ansiMap.put("�", "&#185;");
		ansiMap.put("�", "&#186;");
		ansiMap.put("�", "&#187;");
		ansiMap.put("�", "&#188;");
		ansiMap.put("�", "&#189;");
		ansiMap.put("�", "&#190;");
		ansiMap.put("�", "&#191;");
		ansiMap.put("�", "&#192;");
		ansiMap.put("�", "&#193;");
		ansiMap.put("�", "&#194;");
		ansiMap.put("�", "&#195;");
		ansiMap.put("�", "&#196;");
		ansiMap.put("�", "&#197;");
		ansiMap.put("�", "&#198;");
		ansiMap.put("�", "&#199;");
		ansiMap.put("�", "&#200;");
		ansiMap.put("�", "&#201;");
		ansiMap.put("�", "&#202;");
		ansiMap.put("�", "&#203;");
		ansiMap.put("�", "&#204;");
		ansiMap.put("�", "&#205;");
		ansiMap.put("�", "&#206;");
		ansiMap.put("�", "&#207;");
		ansiMap.put("�", "&#208;");
		ansiMap.put("�", "&#209;");
		ansiMap.put("�", "&#210;");
		ansiMap.put("�", "&#211;");
		ansiMap.put("�", "&#212;");
		ansiMap.put("�", "&#213;");
		ansiMap.put("�", "&#214;");
		ansiMap.put("�", "&#215;");
		ansiMap.put("�", "&#216;");
		ansiMap.put("�", "&#217;");
		ansiMap.put("�", "&#218;");
		ansiMap.put("�", "&#219;");
		ansiMap.put("�", "&#220;");
		ansiMap.put("�", "&#221;");
		ansiMap.put("�", "&#222;");
		ansiMap.put("�", "&#223;");
		ansiMap.put("�", "&#224;");
		ansiMap.put("�", "&#225;");
		ansiMap.put("�", "&#226;");
		ansiMap.put("�", "&#227;");
		ansiMap.put("�", "&#228;");
		ansiMap.put("�", "&#229;");
		ansiMap.put("�", "&#230;");
		ansiMap.put("�", "&#231;");
		ansiMap.put("�", "&#232;");
		ansiMap.put("�", "&#233;");
		ansiMap.put("�", "&#234;");
		ansiMap.put("�", "&#235;");
		ansiMap.put("�", "&#236;");
		ansiMap.put("�", "&#237;");
		ansiMap.put("�", "&#238;");
		ansiMap.put("�", "&#239;");
		ansiMap.put("�", "&#240;");
		ansiMap.put("�", "&#241;");
		ansiMap.put("�", "&#242;");
		ansiMap.put("�", "&#243;");
		ansiMap.put("�", "&#244;");
		ansiMap.put("�", "&#245;");
		ansiMap.put("�", "&#246;");
		ansiMap.put("�", "&#247;");
		ansiMap.put("�", "&#248;");
		ansiMap.put("�", "&#249;");
		ansiMap.put("�", "&#250;");
		ansiMap.put("�", "&#251;");
		ansiMap.put("�", "&#252;");
		ansiMap.put("�", "&#253;");
		ansiMap.put("�", "&#254;");
		ansiMap.put("�", "&#255;");
	}

	public static String replaceAllAnsi(String in) {
		String out = "" + in;
		for (Iterator<String> ansichars = ansiMap.keySet().iterator(); ansichars
				.hasNext();) {
			String readChar = (String) ansichars.next();
			// System.out.println(readChar+ " is in "+out.contains(readChar));
			out = out.replaceAll(readChar, ansiMap.get(readChar));
		}
		return out;
	}
	
		
}
