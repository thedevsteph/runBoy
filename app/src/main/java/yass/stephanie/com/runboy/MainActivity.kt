package yass.stephanie.com.runboy

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.color
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import yass.stephanie.com.runboy.R.color.colorAccent
import yass.stephanie.com.runboy.Utils.*


class MainActivity : AppCompatActivity() {

    companion object {
        private val distanceValue: String = "69"
        private val converter = ConverterUtils()
        private val defaultUserDetails: UserDetails = UserDetails(160F, Gender.FEMALE, 18, 84F)
        private val distanceDetails: DistanceDetails = DistanceDetails(9849, 60F, 84F)
        private val greetingsMessage: String =  "Hello ${defaultUserDetails.firstName}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateDistanceCoveredTodayText(R.id.walked_distance_summary)


        //updateUI
        updateUI()


        val chart: LineChart = findViewById(R.id.measured_values_chart)

        val data: ArrayList<Entry> =
            arrayListOf(
                Entry(1F, 1F),
                Entry(2F, 2F),
                Entry(3F, 5F),
                Entry(4F, 3F),
                Entry(5F, 1F),
                Entry(6F, 2F),
                Entry(7F, 5F),
                Entry(8F, 3F),
                Entry(9F, 1F),
                Entry(11F, 2F),
                Entry(12F, 5F),
                Entry(14F, 3F),
                Entry(15F, 2F),
                Entry(15.4F, 5F),
                Entry(16F, 3F)
            )
        var generatedChart = ChartUtils(chart, data)
        generatedChart.getChart(this)
    }


    private fun updateDistanceCoveredTodayText(id: Int) {
        val textView: TextView = findViewById(id)
        val summaryStringBuilder = SpannableStringBuilder()
            .append("You ran ")
            .color(ContextCompat.getColor(this, colorAccent)) { append("$distanceValue mins ") }
            .append("today")

        textView.text = summaryStringBuilder
    }

    private fun updateUI() {

        val dataSummaryLayout = findViewById<View>(R.id.measured_values_layout)
        val greetingsTextView: TextView = findViewById(R.id.hello_introduction)
        val stepsView: TextView = dataSummaryLayout.findViewById(R.id.distance_value)
        val caloriesView: TextView = dataSummaryLayout.findViewById(R.id.calories_value)
        val pointsView: TextView = dataSummaryLayout.findViewById(R.id.points_value)
        val largeStepsView: TextView = findViewById(R.id.steps_number)

        largeStepsView.text = distanceDetails.steps.toString()
        pointsView.text = converter.convertStepsToPoints(distanceDetails.steps).toString()
        stepsView.text = distanceDetails.steps.toString()
        caloriesView.text = converter.getCaloriesBurned(defaultUserDetails, distanceDetails).toString()
        greetingsTextView.text = greetingsMessage
    }
}
