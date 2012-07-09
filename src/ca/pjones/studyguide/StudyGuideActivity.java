package ca.pjones.studyguide;

import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudyGuideActivity extends ListActivity {
	Boolean classSelected = false;
	String[] lastSelected;
	int lastClassNum;
	String[] classes = {"class1", "class2", "class3", "class4", "class5", "class7", "class8", "class9", "class10", "class11"};
	String[] class1 = {"Algorithm", "Asymptotic_analysis", "Big_O_notation", "Binary_search", "Boyer–Moore_string_search_algorithm", 
			"Closure_(computer_science)", "Data_structure", "Funarg_problem", "Generator_(computer_science)", "Inline_expansion",
			"Interpolation_search", "Knuth–Morris–Pratt_algorithm", "Loop_invariant", "Optimization_(computer_science)", 
			"Rabin–Karp_string_search_algorithm", "Recursion_(computer_science)", "Spaghetti_stack", "String_matching",
			"Tail_recursion"
	};
	HashMap<Integer, String[]> hp = new HashMap<Integer, String[]>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hp.put(0, class1);
        setUpList(classes);
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      if(classSelected == false) {
    	String[] set = (String[]) hp.get(position);
        classSelected = true;
        lastSelected = set;
        lastClassNum = position + 1;
    	setUpList(set);
      } else {
    	  launchViewer("class" + (Integer.toString(lastClassNum)) + "/" + lastSelected[position]);
      }
      super.onListItemClick(l, v, position, id);
    }
    
    private void setUpList(String[] elements) {
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, elements);
        setListAdapter(adapter);
    }
    
    private void launchViewer(String page) {
    	Bundle b = new Bundle();
    	b.putString("page", page);
    	Intent it = new Intent(StudyGuideActivity.this, ViewNotesActivity.class);
    	it.putExtras(b);
    	startActivity(it);
    }
}