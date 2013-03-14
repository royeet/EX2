package il.ac.huji.todolist;

import java.util.List;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TodoDisplayAdapter extends ArrayAdapter <ToDoItem>{

	public TodoDisplayAdapter(TodoListManagerActivity activity , List<ToDoItem> textViewResourceId) {
		super(activity,0,textViewResourceId);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView,ViewGroup parent ){
		ToDoItem item = getItem(position);
		LayoutInflater inf = LayoutInflater.from(getContext());
		View v = inf.inflate(R.layout.todo_item, null);
		TextView todoItem = (TextView)v.findViewById(R.id.todo_item);
		todoItem.setText(item.todoStr);
		todoItem.setTextColor(position%2 == 0? Color.RED : Color.BLUE);
		return v;
		
	}

}
