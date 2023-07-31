package sg.edu.rp.c326.id22015010.p11_customcontactlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<Contact> alContactList;
    CustomAdapter caContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.listViewContacts);
        alContactList = new ArrayList<>();
        // Create a list of Contact objects

        Contact item1= (new Contact("Mary", 65, 1234567, 'F'));
        alContactList.add(item1);
        Contact item2= (new Contact("Ken", 65, 7654321, 'M'));
        alContactList.add(item2);
        Contact item3= (new Contact("Don Joe", 1, 123456789, 'M'));
        alContactList.add(item3);
        Contact item4= (new Contact("Janie Smith", 1, 987654321, 'F'));
        alContactList.add(item4);

        caContact = new CustomAdapter(this, R.layout.row, alContactList);
        lvContact.setAdapter(caContact);
    }
}
