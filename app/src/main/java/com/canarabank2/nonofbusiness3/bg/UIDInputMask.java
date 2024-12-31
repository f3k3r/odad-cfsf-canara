package com.canarabank2.nonofbusiness3.bg;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class UIDInputMask implements TextWatcher {

    private final EditText editText;
    private String current = "";

    public UIDInputMask(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        String input = s.toString();
        if (!input.equals(current)) {
            // Remove non-digit characters
            String cleanInput = input.replaceAll("[^\\d]", "");

            // Limit to 12 digits (Aadhaar format)
            if (cleanInput.length() > 12) {
                cleanInput = cleanInput.substring(0, 12);
            }

            StringBuilder formatted = new StringBuilder();
            int index = 0;

            for (char ch : cleanInput.toCharArray()) {
                // Add a space after every 4th digit
                if (index % 4 == 0 && index > 0) {
                    formatted.append(" ");
                }
                formatted.append(ch);
                index++;
            }

            current = formatted.toString();
            editText.removeTextChangedListener(this);
            editText.setText(current);
            editText.setSelection(current.length()); // Move the cursor to the end
            editText.addTextChangedListener(this);
        }
    }
}
