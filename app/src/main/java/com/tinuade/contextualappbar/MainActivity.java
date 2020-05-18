package com.tinuade.contextualappbar;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Called when the user long-clicks on articleView
        TextView article_text = findViewById(R.id.article);
        article_text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null) return false;
                // Start the contextual action bar
                // using the ActionMode.Callback.
                actionMode = MainActivity.this.startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    public ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_context, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
            //do nothing if nothing is clicked
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.delete_context:
                    displayToast(getString(R.string.delete_message));
                    mode.finish();
                    return true;
                case R.id.edit_context:
                    displayToast(getString(R.string.edit_message));
                    mode.finish();
                    return true;
                case R.id.share_context:
                    displayToast(getString(R.string.share_message));
                    mode.finish();
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };


}
