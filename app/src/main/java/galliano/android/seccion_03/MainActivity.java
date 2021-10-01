package galliano.android.seccion_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import galliano.android.seccion_03.adapters.MyAdapter;
import galliano.android.seccion_03.models.PersonageVo;
import galliano.android.seccion_03.utilities.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private List<PersonageVo>personage;
    private RecyclerView mRecyclerView;
    private final static int LIST =0;
    private MyAdapter mAdapterList;
    private MyAdapter mAdapterGrid;


    private RecyclerView.LayoutManager mLayoutManagerList;
    private RecyclerView.LayoutManager mLayoutManagerGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personage = getAllPersonage();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManagerList = new LinearLayoutManager(this);
        mLayoutManagerGrid = new GridLayoutManager(this,4);

        mAdapterGrid = new MyAdapter(personage, R.layout.item_grid_personage);
        mAdapterList = new MyAdapter(personage, R.layout.recycler_view_item);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManagerGrid);
        mRecyclerView.setAdapter(mAdapterGrid);

        Button btn1 = (Button) findViewById(R.id.btnList);
        Button btn2 = (Button) findViewById(R.id.btnGrid);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(mLayoutManagerList);
                mRecyclerView.setAdapter(mAdapterList);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(mLayoutManagerGrid);
                mRecyclerView.setAdapter(mAdapterGrid);
            }
        });

        mAdapterList.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"Selection: "+personage.get(mRecyclerView.getChildAdapterPosition(view)).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        mAdapterGrid.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"Selection: "+personage.get(mRecyclerView.getChildAdapterPosition(view)).getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private List<PersonageVo> getAllPersonage(){
        return new ArrayList<PersonageVo>(){{
            add(new PersonageVo("Krusty","Herschel Shmoikel Pinkus Yerocham Krustofsky, known as Krusty the Clown, is a character from the cartoon series The Simpsons.",R.mipmap.ic_krusty));
            add(new PersonageVo("Homero","Homer Jay Simpson is one of the protagonists of the series. He is the father of the main family and one of the central and most important characters in the series.",R.mipmap.ic_homero));
            add(new PersonageVo("Marge","Marjorie \"Marge\" Bouvier Simpson one of the protagonists of the series. She is the wife of Homer Simpson and mother of the three children she has had from this love affair: Bart, Lisa and Maggie.",R.mipmap.ic_marge));
            add(new PersonageVo("Bart","Bartholomew JoJo \"Bart\" Simpson, is one of the protagonists of the series. Bart is 10 years old and is the first-born, and only son of Homer and Marge Simpson.",R.mipmap.ic_bart));
            add(new PersonageVo("Lisa","Lisa Marie Simpson is one of the protagonists of the series. She is the middle daughter of Homer and Marge Simpson, and sister of Bart and Maggie. She enjoys notable prominence and complexity in the series.",R.mipmap.ic_lisa));
            add(new PersonageVo("Maggie","Margaret Evelyn \"Maggie\" Simpson is one of the protagonists of the series. She is the third daughter of the main couple, Homer and Marge Simpson, and the youngest of them.",R.mipmap.ic_maggie));
            add(new PersonageVo("Flanders","Nedward \"Ned\" Flanders is a fictional character from the animated television series The Simpsons. The original English voice is Harry Shearer.",R.mipmap.ic_falnders));
            add(new PersonageVo("Milhouse","Milhouse Mussolini Van Houten is a fictional character from the animated series The Simpsons, created by Matt Groening.",R.mipmap.ic_milhouse));
            add(new PersonageVo("Mr. Bruns","Charles Montgomery Burns, better known as Mr. Burns or Monty Burns, is a recurring fictional character from the cartoon television series The Simpsons, created by Matt Groening.",R.mipmap.ic_burns));
        }};
    }
}