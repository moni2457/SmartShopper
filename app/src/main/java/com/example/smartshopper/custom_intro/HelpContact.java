/*
 * MIT License
 *
 * Copyright (c) 2017 Jan Heinrich Reimer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.smartshopper.custom_intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.bumptech.glide.Glide;
import com.example.smartshopper.R;
import com.heinrichreimersoftware.materialintro.app.SlideFragment;

public class HelpContact extends SlideFragment {
    private ViewDataBinding binding;

    public HelpContact() {
        // Required empty public constructor
    }

    public static HelpContact newInstance() {
        return new HelpContact();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_custom_intro, container, false);
        ImageView x = binding.getRoot().findViewById(R.id.slide_image);
        Glide.with(requireContext()).load(R.drawable.mail2).into(x);
        TextView title = (TextView) binding.getRoot().findViewById(R.id.slide_title);
        title.setText("Contact Us");
        title.setTextColor(getResources().getColor(R.color.colorAccent));
        TextView desc = (TextView) binding.getRoot().findViewById(R.id.slide_description);
        desc.setTextColor(getResources().getColor(R.color.colorAccent));
        desc.setText("Write your suggestions to smartshopper@dal.ca");
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean canGoForward() {
        return true;
    }
}
