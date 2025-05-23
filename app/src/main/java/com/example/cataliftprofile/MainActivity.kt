package com.example.cataliftprofile

import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalift.Adapter.MentorAdapter
import com.example.catalift.Modal.Mentor

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var myMentorsBtn: Button
    private lateinit var exploreBtn: Button
    private lateinit var searchView: SearchView
    private lateinit var adapter: MentorAdapter
    private lateinit var fullMentorList: List<Mentor>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        myMentorsBtn = findViewById(R.id.myMentorsBtn)
        exploreBtn = findViewById(R.id.exploreBtn)
        searchView = findViewById(R.id.searchView) // <-- Make sure ID matches XML



        fullMentorList = getDummyMentors()
        adapter = MentorAdapter(fullMentorList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false // optional
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = fullMentorList.filter {
                    it.name.contains(newText.orEmpty(), ignoreCase = true)
                }
                adapter.updateData(filteredList)
                return true
            }
        })
    }

    private fun getDummyMentors(): List<Mentor> {
        return listOf(
            Mentor(R.drawable.nature,
                "4.9",
                "Gaurav Samant",
                "4 years",
                "Business Administration",
                175,
                "Strategy Manager @CEO Office | Ex-eBay & L&T | MDI Gurgaon . ESCP Europe | 32+ National Case Comps Podiums",
                "98%"
            ),
            Mentor(
                R.drawable.nature1,
                "4.8",
                "Shreya Patil",
                "3 years",
                "Marketing",
                125,
                "Brand Manager | Ex-P&G | IIM Calcutta",
                "95%"
            ),
            Mentor(
                R.drawable.nature,
                "4.5",
                "Ankit Sharma",
                "5 years",
                "Finance",
                200,
                "Investment Banker | Goldman Sachs | CFA Level 3",
                "90%"
            )
        )

    }
}