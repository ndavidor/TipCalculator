package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class TipCalculatorActivity extends Activity 
{
	public static String tipIntStr = "Tip: $";
	public static String tipFloatStr = "Tip: $%.2f";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        Button b = (Button) findViewById(R.id.btnCalculate);
        
        b.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) 
			{
				String strBillAmount = (((EditText) findViewById(R.id.edtBillAmount)).getText()).toString();
				Boolean isRound = ((CheckBox) findViewById(R.id.chkRound)).isChecked();
		        TextView result = (TextView) findViewById(R.id.txtTipResult);
		        
				if (strBillAmount.length() == 0)
				{
					result.setText("");
					return;
				}
				
				Double tip = Double.parseDouble(strBillAmount) * 12 / 100;
				
				if (isRound)
				{
					tip = (double) Math.round(tip);
					result.setText(tipIntStr + tip.intValue());
				}
				else
				{
					result.setText(String.format(tipFloatStr, tip));
				}
			}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
}
