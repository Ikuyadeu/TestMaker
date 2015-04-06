package ikuyadeu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;


public class TestMaker {
	@FXML private TextArea label1;
	@FXML private ChoiceBox<String> digit;
	@FXML private ChoiceBox<String> digit2;
	@FXML private ChoiceBox<String> operator;
	@FXML private ChoiceBox<Integer> num;
	@FXML private CheckBox amari;
	@FXML private CheckBox agari;
	@FXML private CheckBox teacher;
	
	private String problem;
	private String answer;
	
	@FXML protected void make(ActionEvent event){
		problem="";
		answer="";
		Integer problemNum = num.getValue();
		if(problemNum==null)problemNum=10;
		String opr = operator.getValue();
		if(opr==null)opr = "＋";
		int dig  = makeDigit(digit.getValue());
		int dig2 = makeDigit(digit2.getValue());
		
		for (int i = 0; i < problemNum; i++) {
			AbstractTest test = new NomalTest(opr,dig,dig2,amari.isSelected(),agari.isSelected());
			test.makeTest();
			String number=(i < 9) ? " "+(i+1) : ""+(i+1);
			problem += "(" + number + ")" + test.getProblem();
			if(teacher.isSelected()){
				problem+= " = "+test.getAnswer() +"\n";
			}
			else{
				problem += "\n";
				answer += "(" + number + ")" + test.getAnswer();
				if((i+1)%5==0)answer+="\n";
			}
		}
		String text = problem;
		if(!teacher.isSelected()) text += "\nこたえ\n"+answer;
		label1.setText(text);
		
	}
	
	//桁数を１０の倍数に変換する
		private int makeDigit(String value){
			if(value==null)return 1;
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

}
