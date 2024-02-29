import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	
	//Calendar calendar;
	SimpleDateFormat timeFormat,dayFormat,dateFormat;
	String time,day,date;
	JLabel timeLabel,dayLabel,dateLabel;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock");
		this.setSize(350,200);
		this.setLayout(new FlowLayout());
		this.setResizable(false);

		timeFormat = new SimpleDateFormat("hh:mm:ss a");    //check oracle's "SimpleDateFormat" documentation for details
		dayFormat = new SimpleDateFormat("EEEE");			//E-short name of day,EEEE-Full name of day
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");//MM-Month in digit, MMM-Short form, MMMMM-Full form
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0xff00));
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,28));
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	void setTime() {
		while(true) {              
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
