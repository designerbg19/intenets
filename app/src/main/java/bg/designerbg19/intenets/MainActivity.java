package bg.designerbg19.intenets;



import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
   private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner =(Spinner)findViewById(R.id.spinner);

        //Button bt = (Button)findViewById(R.id.tester);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.intents,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

     spinner.setAdapter(adapter);

        }
public void tester(View view) {

    int position = spinner.getLastVisiblePosition();

    Intent intent = null;

    switch (position) {
        case 0:
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:999999"));
            break;
        case 1:
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:999999"));
            break;
        case 2:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            break;
        case 3:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194?z=21"));
            intent.setPackage("com.google.android.apps.maps");
            break;
        case 4:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=tunis"));
            intent.setPackage("com.google.android.apps.maps");
            break;
        case 5:
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            break;
        case 6:
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));

            break;
        case 7:
            intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
            break;

        case 8:
            intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            break;
        case 9:
            intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            break;
    }
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }

}
}
