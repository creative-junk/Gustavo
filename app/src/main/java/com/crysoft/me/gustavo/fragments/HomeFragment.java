package com.crysoft.me.gustavo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.crysoft.me.gustavo.R;
import com.crysoft.me.gustavo.adapters.CustomListAdapter;

public class HomeFragment extends Fragment {
    private String[] tabNames = {
            "Find a Part","Find a Store","Find a Mechanic","Deals & Specials","Repairs Help"
    };

    private ListView listView;
    private ViewPager viewPager;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get ViewPager for changing Tabs
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        //Setup the ListView
        listView = (ListView) getActivity().findViewById(android.R.id.list);
        CustomListAdapter listAdapter = new CustomListAdapter(getActivity(),tabNames);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                //Toast.makeText(getActivity(), item + "Selected", Toast.LENGTH_LONG).show();
                switch (item){
                    case "Find a Part":
                       viewPager.setCurrentItem(1);
                        break;
                    case "Find a Store":
                        viewPager.setCurrentItem(2);
                        break;
                    case "Find a Mechanic":
                        viewPager.setCurrentItem(3);
                        break;
                    case "Deals & Specials":

                        break;
                    case "Repairs Help":
                        viewPager.setCurrentItem(4);
                        break;
                    default:
                        break;
                }
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
