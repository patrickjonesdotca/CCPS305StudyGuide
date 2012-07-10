package ca.pjones.studyguide;

import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
	String[] class2 = {"Divide_and_conquer_algorithm", "Memoization", "Dynamic_programming", "Backtracking", "Look_ahead", "Greedy_algorithm" };
	String[] class3 = {"Buffer_overflow", "Dangling_pointer", "Free_list", "Function_pointer", "Garbage_collection_(computer_science)",
			"Malloc", "Memory_leak", "Opaque_pointer", "Pointer_(computer_programming)", "Reference_counting", "Smart_pointer"
	};
	String[] class4 = {"Dancing_links", "Disjoin_set_data_structure", "Doubled_ended_queue", "Linked_list", "Memory_pool",
			"Queue_(data_structure)", "Stack_(data_structure)"
	};
	String[] class5 = {"Binary_decision_diagram", "Binomial_heap", "Buddy_memory_allocation", "Cycle_detection", "Dynamic_memory_allocation",
			"Fragmentation_(computer)", "Rope_(computer_science)", "Tombstone_(programming)", "Trie"
	};
	HashMap<Integer, String[]> hp = new HashMap<Integer, String[]>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hp.put(0, class1);
        hp.put(1, class2);
        hp.put(2, class3);
        hp.put(3, class4);
        hp.put(4, class5);
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
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	classSelected = false;
        	setUpList(classes);
            return true;
        }
        return super.onKeyDown(keyCode, event);
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