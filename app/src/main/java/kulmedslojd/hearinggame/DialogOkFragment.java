package kulmedslojd.hearinggame;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


/**
 * Created by Thomas on 2017-04-26.
 */

public class DialogOkFragment extends DialogFragment {


    public DialogOkFragment() {
        // Empty constructor required for DialogFragment
    }

    public static DialogOkFragment newInstance(String title, String message, boolean adFree) {
        DialogOkFragment frag = new DialogOkFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        args.putBoolean("adfree", adFree);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public @NonNull Dialog onCreateDialog(Bundle  savedInstanceState) {
        assert getArguments() != null;
        String title =  getArguments().getString( "title");
        String message = getArguments().getString("message");
        final boolean adFree = getArguments().getBoolean("adfree");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton(getString(R.string.ok),  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (adFree){
                    if (getActivity() != null)
                    getActivity().finish();
                }
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        return alertDialogBuilder.create();
    }
}
