package imise;

class Rule {
	int line;
	String compOID;
	private String val;
	String min;
	String max;
	String msg;
	String eval;
	String expression;
	enum RuleType { AFTER,BEFORE, ASSERT,REQUIRED,EMPTY,EXPRESSION,RANGE };
	RuleType ruleType;
	String email;
	
	Rule(RuleType ruleType,
			String compOID,
			String expression,
			String val, String min, String max,String msg,int rowNum,String email) {
		this.ruleType = ruleType;
		this.compOID = compOID;
		this.expression = expression;
		this.val = val;
		this.min = min;
		this.max = max;
		this.msg = msg;
		this.email = email;
		line=rowNum;
		eval = "true";
	}
	String expr(String target) throws Exception {
		String r = "";
		switch(ruleType) {
		case BEFORE: 
			if (!min.isEmpty() && !max.isEmpty()) {
				r  = compOID + " lt " + target + " or " + compOID + " - " + target + " lt " + min + " and " + compOID + " - " + target + " gt " + max;
			} else if (!min.isEmpty()) {
				r =  compOID + " lt " + target + " or " + compOID + " - " + target + " lt " + min;
			} else if (!max.isEmpty()) {
				r =  compOID + " lt " + target + " or " + compOID + " - " + target + " gt " + max;
			} else {
				r = compOID + " lt " + target;
			}
			break;
		case AFTER:
			/*
			 * OC 3.0.4.1 berechnet bei a-b eher abs(a-b)
			 * also ist bei der Mehrtagesdifferenz ein zusatztest a lt b and notwendig  
			 */
			if (!min.isEmpty() && !max.isEmpty()) {
				r  = target + " lt " + compOID + " or " + target + " - " + compOID + " lt " + min + " and " + target + " - " + compOID + " gt " + max;
			} else if (!min.isEmpty()) {
				r =  target + " lt " + compOID + " or " + target + " - " + compOID + " lt " + min;
			} else if (!max.isEmpty()) {
				r =  target + " lt " + compOID + " or " + target + " - " + compOID + " gt " + max;
			} else {
				r = target + " lt " + compOID;
			}
			break;
		case ASSERT:
			if (compOID.isEmpty()) compOID=target;
			compOID = compOID.toUpperCase();
			if (val.isEmpty()) throw new Exception(line + ": val is empty");
			val = val.replaceFirst(" ([0-9]+)"," \"$1\"");
			r = compOID + " " + val;
			break;
		case REQUIRED:
			if (!min.isEmpty() && !max.isEmpty()) {
				r = target + " lt " + min + " and " + target + " gt " + max;
			} else if (!min.isEmpty()) {
				r = target + " lt " + min;
			} else if (!max.isEmpty()) {
				r = target + " gt " + max;
			} else {
				r = target + " eq \"\"";	
			}
			if (!compOID.isEmpty()) {
				compOID = compOID.toUpperCase();
				if (val.isEmpty()) throw new Exception(line + ": val is empty");
				val = val.replaceFirst(" ([0-9]+)"," \"$1\"");
				r += " and " + compOID + " " + val;
			}
			break;
		case EXPRESSION:
			if (expression.startsWith("not ")) { eval="false"; expression = expression.substring(4); }
			// $iItem -->itemprefix+upperCase
			r = expression;
			break;
		case EMPTY:
			compOID = compOID.toUpperCase();
			// Zahlen in "" setzen
			val = val.replaceFirst(" ([0-9]+)"," \"$1\"");
			r = target + " ne " + "\"\"" + " and " + compOID + " " + val;
			break;
		case RANGE:
			if (!compOID.isEmpty()) {
				r = compOID + " eq \"" + val + "\" and ( ";
			}
			if (!min.isEmpty() && !max.isEmpty()) {
				r += target + " lt " + min + " or "  + target + " gt " + max;
			} else if (!min.isEmpty()) {
				r += target + " lt " + min;
			} else if (!max.isEmpty()) {
				r += target + " gt " + max;
			} else assert(false);
			if (!compOID.isEmpty()) r += " )";
		}
		return r;
	}
}