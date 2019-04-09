package droidwelt.ru.navigationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Date;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void displayTime() {
        Date dt = new Date();
        setTitle(String.valueOf(dt));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addaction:
                displayTime();
                return true;
        }

        NavigationUI.onNavDestinationSelected(item, navController);
        return super.onOptionsItemSelected(item);
    }


    public void onFragment1NextClick() {
        navController.navigate(R.id.fragment2);
    }

    public void onFragment1BackClick() {
    }


    public void onFragment2NextClick() {
        navController.navigate(R.id.fragment3);
    }

    public void onFragment2BackClick() {
        navController.popBackStack();
    }


    public void onFragment3NextClick() {
    }

    public void onFragment3BackClick() {
        navController.popBackStack();
      //  navController.navigate(R.id.fragment1);
    }
}
