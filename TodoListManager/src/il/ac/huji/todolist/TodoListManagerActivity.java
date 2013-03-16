package il.ac.huji.todolist;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;



public class TodoListManagerActivity extends Activity {

	private ArrayAdapter<ToDoItem> adapter;
	private List<ToDoItem> todoItemsList;
	ListView todoListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list);
		todoItemsList = new ArrayList<ToDoItem>();
		adapter = new TodoDisplayAdapter(this, todoItemsList);
		todoListView = (ListView) findViewById(R.id.lstTodoItems);
		todoListView.setAdapter(adapter);		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_todo_list, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuItemAdd:
			addNewItem();
			break;

		case R.id.menuItemDelete:
			RemoveItem();
			break;
		}
		return true;
	}

	private void RemoveItem() {		
		ListView lv = (ListView) findViewById(R.id.lstTodoItems);
		if (lv.getSelectedItem()== null){
			return;
		}
		adapter.remove((ToDoItem) lv.getSelectedItem());
	}

	private void addNewItem() {
		EditText et = (EditText) findViewById(R.id.edtNewItem);
		
		String newItem = et.getText().toString();
		if (newItem.equals(""))return;
		adapter.add(new ToDoItem(newItem));
		et.setText("");
	}

}
