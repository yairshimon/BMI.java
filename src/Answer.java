import javax.swing.*;
public class Answer {
    JLabel answer;
    public Answer(float answerUser, double idealWeight , float yourWeight){
            answer = new JLabel("");
            if (answerUser < 0.0015) answer.setText("You Anorexic ");
            if (answerUser > 0.0015 && answerUser < 0.00185) answer.setText("You Underweight ");
            if (answerUser >0.00185 && answerUser < 0.00249) answer.setText("You Normal");
            if (answerUser > 0.00249 && answerUser < 0.0029) answer.setText ("You Overweight");
            if (answerUser > 0.00300 && answerUser < 0.0035 ) answer.setText("You Obese");
            if (answerUser >  0.0035 ) answer.setText("You Extreme Obese\n ");
            JOptionPane.showMessageDialog(null, answer);
            JOptionPane.showMessageDialog(null, "Your correct weight is " + yourWeight +". ideal weight is " + idealWeight);
    }
}

