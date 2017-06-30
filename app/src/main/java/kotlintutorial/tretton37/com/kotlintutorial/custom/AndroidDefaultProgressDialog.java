package kotlintutorial.tretton37.com.kotlintutorial.custom;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import kotlintutorial.tretton37.com.kotlintutorial.R;


/**
 * Created by ilkinartuc on 05/09/16.
 */
public class AndroidDefaultProgressDialog extends ProgressDialog
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);

    }

    public AndroidDefaultProgressDialog(Context context)
    {
        super(context);
    }

    public AndroidDefaultProgressDialog(Context context, int theme)
    {
        super(context, theme);
    }

    @Override
    public void show()
    {
        super.show();
    }

    @Override
    public void dismiss()
    {
        try
        {
            super.dismiss();
        } catch (Exception e)
        {

        }
    }
}
