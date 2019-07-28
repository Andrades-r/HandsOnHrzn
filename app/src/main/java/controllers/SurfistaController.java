package controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import BancoHelper.CriarBanco;

public class SurfistaController {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public SurfistaController(Context context){
        banco = new CriarBanco(context);
    }

    public String inserirSurfista(String nome, String pais){

        this.db = banco.getWritableDatabase();
        long res;
        ContentValues valores = new ContentValues();
        valores.put(CriarBanco.COL_SURFISTA_NOME, nome);
        valores.put(CriarBanco.COL_SURFISTA_PAIS, pais);

        res = db.insert(CriarBanco.TABELA_SURFISTA,null, valores);
        this.db.close();

        if(res != -1){
            return "Surfista inserio com sucesso";
        }
        return "Erro ao adicionar o surfista";
    }

    public Cursor buscarTodos(){
        Cursor cursor;
        String[] campos = {banco.COL_SURFISTA_ID,banco.COL_SURFISTA_NOME, banco.COL_SURFISTA_PAIS};
        db = banco.getReadableDatabase();

        cursor = db.query(banco.TABELA_SURFISTA,campos, null,null, null,
                 null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor buscarPorId(int id){
        Cursor cursor;
        String[] campos = {banco.COL_SURFISTA_ID,banco.COL_SURFISTA_NOME, banco.COL_SURFISTA_PAIS};
        String where = banco.COL_SURFISTA_ID+"="+id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA_SURFISTA, campos, where, null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();

        return cursor;
    }

    public Cursor bucarPorPais(String pais){
        Cursor cursor;
        String[] campos = {banco.COL_SURFISTA_ID,banco.COL_SURFISTA_NOME, banco.COL_SURFISTA_PAIS};
        String where = banco.COL_SURFISTA_PAIS+"="+"\""+pais+"\"";
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA_SURFISTA, campos, where, null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();

        return cursor;

    }

    public Cursor bucarPorNome(String nome){
        Cursor cursor;
        String[] campos = {banco.COL_SURFISTA_ID,banco.COL_SURFISTA_NOME, banco.COL_SURFISTA_PAIS};
        String where = banco.COL_SURFISTA_NOME+"="+"\""+nome+"\"";
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA_SURFISTA, campos, where, null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();

        return cursor;
    }

    public Cursor bucarPorNomePais(String nome,String pais){
        Cursor cursor;
        String[] campos = {banco.COL_SURFISTA_ID,banco.COL_SURFISTA_NOME, banco.COL_SURFISTA_PAIS};
        String where = banco.COL_SURFISTA_NOME+"="+"\""+nome+"\"" +" AND "+banco.COL_SURFISTA_PAIS+"="+"\""+pais+"\"";
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA_SURFISTA, campos, where, null,null,null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();

        return cursor;
    }


    public void alterarSurfista(int id, String Nome, String Pais){
        db = banco.getWritableDatabase();
        String where = banco.COL_SURFISTA_ID + "=" + id;
        ContentValues valores = new ContentValues();

        valores.put(banco.COL_SURFISTA_NOME, Nome);
        valores.put(banco.COL_SURFISTA_PAIS, Pais);

        db.update(banco.TABELA_SURFISTA, valores, where, null);
        db.close();
    }

    public void deletarSurfista(int id){
        String where = banco.COL_SURFISTA_ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(banco.TABELA_SURFISTA,where,null);
        db.close();
    }

}
