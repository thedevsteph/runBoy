package yass.stephanie.com.runboy.Utils

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import yass.stephanie.com.runboy.R


class ChartUtils(chart: LineChart, data: ArrayList<Entry>) {


    private val dataSet = LineDataSet(data, "")
    private val chart = chart


    fun getChart(context: Context) {
        dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        dataSet.setDrawFilled(true)
        dataSet.color = ContextCompat.getColor(context, R.color.colorBrightGreen)
        dataSet.fillColor = ContextCompat.getColor(context, R.color.colorBrightGreen)
        dataSet.setDrawValues(false)

        chart.apply {
            setGridBackgroundColor(Color.WHITE)
            setNoDataText("Cannot get chart data")
            description.isEnabled = false
            legend.isEnabled = false
            axisRight.isEnabled = false

            xAxis.position = XAxis.XAxisPosition.BOTTOM

            axisRight.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            xAxis.setDrawGridLines(false)


            animateY(3000, Easing.EaseOutBack)
            setDrawBorders(false)
            data = LineData(dataSet)
            invalidate()
        }
    }


}



