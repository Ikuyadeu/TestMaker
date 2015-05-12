package ikuyadeu;
//整数のテスト
public class NomalTest extends AbstractTest {

	boolean agari;

	public NomalTest(String operator, int digit1, int digit2,int floutnum,
			boolean amari,boolean agari) {
		this.operator = operator;
		this.digit1 = digit1;
		this.digit2 = digit2;
		this.floutnum = floutnum;
		this.amari = amari;
		this.agari = agari;
	}

	@Override
	public void makeTest() {
		int value1 = makeValue(this.digit1);
		int value2 = makeValue(this.digit2);
		switch (this.operator) {
		case "＋":
			while (kuriagari(value1, value2)) {
				value1 = makeValue(this.digit1);
				value2 = makeValue(this.digit2);
			}
			this.answer = "" + ((double)((value1 + value2) / floutnum));
			break;
		case "－":
			//マイナスの値になる場合、繰り上がり・繰り下がりなしの場合やり直し
			while ((digit1 == digit2 && (value1 - value2) < 0) || kurisagari(value1,value2)) {
				value1 = makeValue(this.digit1);
				value2 = makeValue(this.digit2);
			}
			this.answer = "" + (value1 - value2);
			break;
		case "×":
			this.answer = "" + (value1 * value2);
			break;
		case "÷":
			if (digit1 >= digit2) {
				//商が大きくなりすぎる問題だとやり直し
				while (((value1 / value2) > 10 && (digit1 / digit2) == 10
						|| (value1 / value2) == 0 && (digit1 == digit2)
						|| !((value1 % value2) == 0 ^ amari) || value2 == 1)) {
					value1 = makeValue(this.digit1);
					value2 = makeValue(this.digit2);
				}
			}
			this.answer = "" + (value1 / value2);
			if (amari)
				answer += "あまり" + (value1 % value2);
			break;
		default:
			this.answer = "?";
		}
		this.problem = (double)(value1/floutnum) + this.operator + value2;
	}

	// 桁数によって適当な乱数を生成する。
	private int makeValue(int digit) {
		digit *= floutnum;
		int randValue = (int) (Math.random() * digit * 9 + digit);
		return randValue;
	}

	//繰り上がりがあるか判定
	private boolean kuriagari(int v1, int v2) {
		int digit=(digit1>digit2)?digit2:digit1;
		if (agari) {
			for (int i = 10; i <= digit*10; i *= 10) {
				if ((v1 % i + v2 % i) >= i)
					return true;
			}
		}
		return false;
	}
	//繰り下がりがあるか判定
	private boolean kurisagari(int v1,int v2){
		if (digit1 >= digit2 && agari) {
			for(int i = 10; i <= digit2*10; i *= 10){
				if ((v1 % i - v2 % i) < 0)return true;
			}
		}
		return false;
	}

}
