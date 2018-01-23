package com.example.hp.searchview.activitys;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hp.searchview.R;
import com.example.hp.searchview.adapters.FilmAdapter;
import com.example.hp.searchview.controllers.Common;
import com.example.hp.searchview.interfaces.RecyclerViewOnClickListener;
import com.example.hp.searchview.models.Film;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, RecyclerViewOnClickListener {
    private RecyclerView rv;
    private FilmAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        loadData();
        adapter = new FilmAdapter(MainActivity.this, Common.filmList, this);
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    private void loadData() {
        Common.filmList.add(new Film("Igor:The Movie", "http://kinogo.cc/uploads/posts/2014-11/1415991986_igor.1.jpg", "Animated fable about a cliché hunchbacked evil scientist's assistant who aspires to become a scientist himself, much to the displeasure of the rest of the evil science community.", "Джон Кьюсак, Стив Бушеми, Шон Хейс", "Энтони Леондис"));
        Common.filmList.add(new Film("All Dogs Go To Heaven", "https://img00.deviantart.net/d182/i/2017/146/4/5/charlie___all_dogs_go_to_heaven_by_ravenevert-dbahzs1.png", "When a casino owning dog named Charlie is murdered by his rival Carface, he finds himself in Heaven basically by default since all dogs go to heaven.", " Dom DeLuise, Burt Reynolds,Judith Barsi", " Gary Goldman"));
        Common.filmList.add(new Film("Paulie:The Moview", "http://www.pastposters.com/cw3/assets/product_expanded/(JamieR)__Paulie(1).jpg", "Paulie, an intelligent parrot who actually talks, relates the story of his struggle to a Russian immigrant who works as a janitor at the research institute where he is housed and neglected.", "Gena Rowlands,Tony Shalhoub,Cheech Marin", "Bruce Davison"));
        Common.filmList.add(new Film("Fred:The Moview", "https://mwprod.s3-eu-west-1.amazonaws.com/fw/cm/image/39/652279/o_18saf51r6u26g4i5mrtvso6ra_1024_io.jpg", "This is the story of Fred as he goes through a weekend trying to find how to get Judy to fall in love with him. He has to deal with Kevin bulling him and various problems trying to get Judy to come over to his house", "Lucas Cruikshank, Pixie Lott, Jake Weary | See full cast & crew", " Clay Weiner"));
        Common.filmList.add(new Film("Fluke:The Movie", "https://i.ytimg.com/vi/eqq4kk6hmzI/maxresdefault.jpg", "After a man dies in a car crash, he is reincarnated as a dog and attempts to reconnect with his family.", " Matthew Modine, Nancy Travis, Samuel L. Jackson", " Carlo Carlei"));
        Common.filmList.add(new Film("The Secrets of Nimth", "http://assets2.ignimgs.com/2015/03/04/the-secret-of-nimh-1280jpg-c2612c_1280w.jpg", "To save her ill son, a field mouse must seek the aid of a colony of rats, with whom she has a deeper link than she ever suspected.", " Elizabeth Hartman, Derek Jacobi, Dom DeLuise", " Don Bluth"));
        Common.filmList.add(new Film("Sea Level", "http://ibdp.huluim.com/show_art/13974?size=900x350", "Pup discovers human poachers stealing eggs from his reef. As he leaves the sea to rescue the eggs he'll enter the dangerous world of humans.", " Maxwell Vreeland Andrew, Steven Bone, Colin Chong", "Aun Hoe Goh"));
        Common.filmList.add(new Film("Chitty Chitty Bang Bang", "https://i.pinimg.com/originals/5e/94/7b/5e947bd3ee7b832493fca045db962047.jpg", "A down-on-his-luck inventor turns a broken-down Grand Prix car into a fancy vehicle for his children, and then they go off", " Dick Van Dyke, Sally Ann Howes, Lionel Jeffries", "Ken Hughes"));
        Common.filmList.add(new Film("Agent Cody Bank", "http://www.kungenslya.se/movies/Filmomslag/tt0358349.jpg", "A government agent trains Cody Banks in the ways of covert operations that require younger participants.", " Frankie Muniz, Hilary Duff, Andrew Francis", "Harald Zwart"));

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Film> newList = new ArrayList<>();
        for (Film film : Common.filmList) {
            String name = film.getName().toLowerCase();
            if (name.contains(newText)) {
                newList.add(film);
            }
        }
        adapter.setFilter(newList);
        return true;
    }

    @Override
    public void onItemClick(View v, int position) {

        switch (v.getId()) {
            case R.id.iv_image:
                Intent intent = new Intent(MainActivity.this, FilmDetailActivity.class);
                intent.putExtra("key", position);
                startActivity(intent);

        }
    }
}
