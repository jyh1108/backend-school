package dev.example.jvm.oom.lotto2;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        while (true) {
            List<Integer> lottoNumbers = generator.generate();
            System.out.println(lottoNumbers);

            if(lottoHistory.size() >100){
                lottoHistory.clear();
            }
            lottoHistory.add(lottoNumbers);

        }
    }
}