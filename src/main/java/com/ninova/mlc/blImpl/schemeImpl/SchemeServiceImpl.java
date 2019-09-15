package com.ninova.mlc.blImpl.schemeImpl;

import com.ninova.mlc.bl.Scheme.SchemeService;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.SchemeVO;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Service
public class SchemeServiceImpl implements SchemeService {
    @Override
    public ResponseVO acquireScheme(int userID) {
        try {
            SchemeVO schemeVO=new SchemeVO();
            ArrayList<String> stock=executePY("src\\main\\resources\\pythonFile\\stock.py",-1);
            ArrayList<String> unDealedComsumption=executePY("src\\main\\resources\\pythonFile\\algo\\classifyUser.py",userID);
            String[] stringComsumption_ration=unDealedComsumption.get(0).split(" ");
            ArrayList<Double> Comsumption_ration=new ArrayList<>();
            for(int i=0;i<stringComsumption_ration.length;i++){
                Comsumption_ration.add(Double.valueOf(stringComsumption_ration[i]));
            }
            String[] string_plus_or_minus=unDealedComsumption.get(1).split(" ");
            ArrayList<Double> plus_or_minus=new ArrayList<>();
            for(int i=0;i<stringComsumption_ration.length;i++){
                plus_or_minus.add(Double.valueOf(string_plus_or_minus[i]));
            }
            schemeVO.setStockRank(stock);
            schemeVO.setComsumption_ration(Comsumption_ration);
            schemeVO.setPlus_or_minus(plus_or_minus);
            return ResponseVO.buildSuccess(schemeVO);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }



    }
    public ArrayList<String> executePY(String command,int userID){
        try {
            String exe = "python";
            if(userID!=-1){
                command+=" "+String.valueOf(userID);
            }
            command=exe+" "+command;
            Process process = Runtime.getRuntime().exec(command);
            InputStream is = process.getInputStream();
            InputStreamReader dat=new InputStreamReader(is);
            BufferedReader bin=new BufferedReader(dat);
            String str="";
            ArrayList<String> output=new ArrayList<>();
            while((str=bin.readLine())!=null) {
                output.add(str);

            }
            return output;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
