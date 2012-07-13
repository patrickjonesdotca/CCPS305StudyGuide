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
	String[] classes = {"class1", "class2", "class3", "class4", "class5", "class7", "class8", "class9", "class10"};
	String[] class1 = {"Algorithm", "Asymptotic_analysis", "Big_O_notation", "Binary_search", "Boyer_Moore_string_search_algorithm", 
			"Closure_(computer_science)", "Data_structure", "Funarg_problem", "Generator_(computer_science)", "Inline_expansion",
			"Interpolation_search", "Knuth_Morris_Pratt_algorithm", "Loop_invariant", "Optimization_(computer_science)", 
			"Rabin_Karp_string_search_algorithm", "Recursion_(computer_science)", "Spaghetti_stack", "String_matching",
			"Tail_recursion"
	};
	String[] class2 = {"Divide_and_conquer_algorithm", "Memoization", "Dynamic_programming", "Backtracking", "Look_ahead_(backtracking)", "Greedy_algorithm" };
	String[] class3 = {"Buffer_overflow", "Dangling_pointer", "Free_list", "Function_pointer", "Garbage_collection_(computer_science)",
			"Malloc", "Memory_leak", "Opaque_pointer", "Pointer_(computer_programming)", "Reference_counting", "Smart_pointer"
	};
	String[] class4 = {"Dancing_Links", "Disjoint_set_data_structure", "Doubled_ended_queue", "Linked_list", "Memory_pool",
			"Queue_(data_structure)", "Stack_(data_structure)"
	};
	String[] class5 = {"Binary_decision_diagram", "Binomial_heap", "Buddy_memory_allocation", "Cycle_detection", "Dynamic_memory_allocation",
			"Fragmentation_(computer)", "Rope_(computer_science)", "Tombstone_(programming)", "Trie"
	};
	String[] class7 = {"Bead_sort", "Binary_tree_sort", "Bogosort", "Bubble_sort",
			"Bucket_sort", "Bucket_sort_integer_keys", "Cocktail_sort", "Comb_sort", "Counting_sort", "Cycle_sort", 
			"Gnome_sort", "Heapsort", "In-place", "Insertion_sort", "Introsort", "Library_sort", "Merge_sort", 
			"Pancake_sorting", "Patience_sorting", "Pigeonhole_sort", "Quicksort", "Radix_sort_LSD", "Radix_sort_MSD", 
			"Selection_sort", "Shell_sort", "Smoothsort", "Sorting_algorithm", "Sorting_network", "Spaghetti_sort", 
			"Spreadsort", "Strand_sort", "Timsort", "Tournament_sort", "Selection_algorithm"};
	String[] class8 = {"Binary_heap", "Bloom_filter", "Cryptographic_hash_function", "D_ary_heap",
	                       "Hash_function", "Hash_table", "Priority_queue", "Universal_hashing"};
	String[] class9 = {"AVL_tree", "Binary_search_tree", "Binary_space_partitioning", "Persistent_data_structure", 
			"Quadtree", "Red_black_tree", "Splay_tree", "Treap", "Tree_(computer_science)"};
	String[] class10 = {"Adjacency_list", "Adjacency_matrix", "A_star_algorithm", "Breadth_first_search", 
			"Depth_first_search", "Depth_limited_search", "Dijkstras_algorithm", "Graph_(mathematics)", 
			"Strongly_connected_components", "Tarjan's_strongly_connected_components_algorithm", "Topological_sorting"};
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
        hp.put(5, class7);
        hp.put(6, class8);
        hp.put(7, class9);
        hp.put(8, class10);
        setUpList(classes);
        
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      if(classSelected == false) {
    	String[] set = (String[]) hp.get(position);
        classSelected = true;
        lastSelected = set;
        lastClassNum = position >= 5 ? position + 2 : position + 1;
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