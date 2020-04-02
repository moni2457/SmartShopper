package com.example.smartshopper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CompoundBarcodeView


class Barcode_custom : Fragment() {
    lateinit var barcodeView: CompoundBarcodeView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (container == null) {
            return null
        }
        val v: View
        v = inflater.inflate(R.layout.fragment_barcode, container, false)
        barcodeView = v.findViewById(R.id.barcode_scanner)
        barcodeView.decodeContinuous(callback)
        return v
    }

    private val callback: BarcodeCallback = object : BarcodeCallback {
        override fun barcodeResult(result: BarcodeResult) {
            if (result.text != null) {
                barcodeView.setStatusText(result.text)
            }
            //Do something with code result
            Toast.makeText(requireContext(), result.text, Toast.LENGTH_LONG).show()
        }

        override fun possibleResultPoints(resultPoints: List<ResultPoint>) {}
    }

    override fun onResume() {
        barcodeView.resume()
        super.onResume()
    }

    override fun onPause() {
        barcodeView.pause()
        super.onPause()
    }
}