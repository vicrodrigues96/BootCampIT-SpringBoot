package br.com.bootcamp.calculadoraidade.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

@Service
public class CalculadoraIdadeService {

    public Integer calculaData(Date data) {
        Date dataAtual = new Date(System.currentTimeMillis());
        Calendar data1 = getCalendar(data);
        Calendar data2 = getCalendar(dataAtual);
        int diff = data2.get(YEAR) - data1.get(YEAR);

        if (data1.get(MONTH) > data2.get(MONTH) ||
                (data1.get(MONTH) == data2.get(MONTH) && data1.get(DATE) > data2.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
