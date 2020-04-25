package fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.AlarmReceiver;
import com.example.mydictionary.R;

import java.sql.Time;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;

public class BookmarkFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.fragment_bookmark_recyclerview);
        super.onViewCreated(view, savedInstanceState);
    }

    /*int alarmHour = timePicker.getHour();
                int alarmMinute = timePicker.getMinute();

                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getContext(), AlarmReceiver.class);
                intent.setAction("alarm action");
                intent.putExtra("key_alarm_action", "ALARM!!!!!!!!!!!");

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, alarmHour);
                calendar.set(Calendar.MINUTE, alarmMinute);

                long timeInMillis = calendar.getTimeInMillis();

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis,AlarmManager.INTERVAL_DAY, pendingIntent);*/
}
