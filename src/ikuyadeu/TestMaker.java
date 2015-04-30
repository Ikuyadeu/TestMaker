package ikuyadeu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class TestMaker {
	@FXML
	private TextArea label1;
	@FXML
	private ChoiceBox<String> digit;// 第一の桁数
	@FXML
	private ChoiceBox<String> digit2;// 第二の桁数
	@FXML
	private ChoiceBox<String> operator;// 演算子
	@FXML
	private ChoiceBox<String> num;// 問題数
	@FXML
	private ChoiceBox<String> columnNum;// 表示する列数
	@FXML
	private CheckBox amari;// あまりの有無
	@FXML
	private CheckBox agari;// 繰り上がり・繰り下がりの有無
	@FXML
	private CheckBox teacher;// 先生用

	private String problem;// 問題の内容
	private String answer;// 答え

	@FXML
	protected void make(ActionEvent event) {
		problem = "";
		answer = "";
		String end;
		String opr = operator.getValue();
		if (opr == null)
			opr = "＋";
		int dig = makeDigit(digit.getValue());
		int dig2 = makeDigit(digit2.getValue());
		int problemNum = makeProblemnum(num.getValue());
		int newLine = makeColumnNum(columnNum.getValue());
		for (int i = 0; i < problemNum; i++) {
			end = (i%newLine==0 && i!= 0)?"\n":"    ";
			AbstractTest test = new NomalTest(opr, dig, dig2,
					amari.isSelected(), agari.isSelected());
			test.makeTest();
			String number = (i < 9) ? " " + (i + 1) : "" + (i + 1);
			problem += "(" + number + ")" + test.getProblem();
			if (teacher.isSelected()) {
				problem += " = " + test.getAnswer() + end;
			} else {
				problem += end;
				answer += "(" + number + ")" + test.getAnswer();
				if ((i + 1) % 5 == 0)
					answer += end;
			}
		}
		String text = problem;
		if (!teacher.isSelected())
			text += "\nこたえ\n" + answer;
		label1.setText(text);

	}

	// 桁数を１０の倍数に変換する
	private int makeDigit(String value) {
		if (value == null)
			return 1;
		switch (value) {
		case "１けた":
			return 1;
		case "２けた":
			return 10;
		case "３けた":
			return 100;
		case "４けた":
			return 1000;
		default:
			return 1;
		}

	}

	// 問題数を整数に変換する
	private int makeProblemnum(String value) {
		switch (value) {
		case "10もん":
			return 10;
		case "20もん":
			return 20;
		case "50もん":
			return 50;
		case "100もん":
			return 100;
		default:
			return 1;
		}
	}

	// 問題数を整数に変換する
	private int makeColumnNum(String value) {
		switch (value) {
		case "1列":
			return 1;
		case "2列":
			return 2;
		case "3列":
			return 3;
		case "4列":
			return 4;
		default:
			return 1;
		}
	}

}
