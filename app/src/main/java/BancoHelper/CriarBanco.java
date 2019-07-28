package BancoHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CriarBanco extends SQLiteOpenHelper {

    private static final String DATABASE_NOME = "surf.db";
    private static final int DATABASE_VERSION = 1;

    //TABELA SURFISTAS
    public static final String TABELA_SURFISTA = "surfista";
    public static final String COL_SURFISTA_ID = "_id";
    public static final String COL_SURFISTA_NOME = "nome";
    public static final String COL_SURFISTA_PAIS = "pais";

    //TABELA BATERIA
    public static final String TABELA_BATERIA = "baterias";
    private static final String COL_BATERIA_ID = "_id";

    //TABELA BATERIA_SURFISTA
    public static final String TABELA_BATERIA_SURFISTA = "baterias_surfistas";
    public static final String COL_BATERIA_SURF_ID ="_id";
    public static final String COL_BATERIA_ID_REF = "bateria_id";
    public static final String COL_SURFISTA_ID_REF = "surfista_id";

    //TABELA ONDA
    public static final String TABELA_ONDA = "ondas";
    public static final String COL_ONDA_ID = "_id";
    public static final String COL_BATERIA = "bateria_id";
    public static final String COL_SURFISTA = "surfista_id";

    //TABELA NOTA
    public static final String TABELA_NOTA = "notas";
    public static final String COL_NOTA_ID = "_id";
    public static final String COL_ONDA_ID_REF = "onda_id";

    //NOTAS PARCIAIS
    public static final String TABELA_NOTA_PARCIAL = "notas_parciais";
    public static final String COL_NOTA_PARCIAL_ID = "_id";
    public static final String COL_NOTA_REF = "nota_id";
    public static final String COL_NOTA_VALOR = "valor";

    private static final String SQL_CREATE_TABLE_SURFISTAS = "CREATE TABLE "+TABELA_SURFISTA+"("
            +COL_SURFISTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_SURFISTA_NOME+" TEXT NOT NULL, "
            +COL_SURFISTA_PAIS+" TEXT NOT NULL "
            +");";

    private static final String SQL_CREATE_TABLE_BATERIA = "CREATE TABLE "+TABELA_BATERIA+"("
            +COL_BATERIA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "
            +");";

    private static final String SQL_CREATE_TABLE_BATERIA_SURFISTA = "CREATE TABLE "+TABELA_BATERIA_SURFISTA+"("
            +COL_BATERIA_SURF_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_BATERIA_ID_REF+" INTEGER, "
            +COL_SURFISTA_ID_REF+" INTEGER, "
            +"FOREIGN KEY("+COL_BATERIA_ID_REF+") REFERENCES " +TABELA_BATERIA+"("+COL_BATERIA_ID+"),"
            +"FOREIGN KEY("+COL_SURFISTA_ID_REF+") REFERENCES "+TABELA_SURFISTA+"("+COL_SURFISTA_ID+")"
            +");";

    private static final String SQL_CREATE_TABLE_ONDA="CREATE TABLE "+TABELA_ONDA+"("
            +COL_ONDA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_SURFISTA+" INTEGER NOT NULL, "
            +COL_BATERIA+" INTEGER, "
            +"FOREIGN KEY("+COL_BATERIA+") REFERENCES " +TABELA_BATERIA+"("+COL_BATERIA_ID+"),"
            +"FOREIGN KEY("+COL_SURFISTA+") REFERENCES "+TABELA_SURFISTA+"("+COL_SURFISTA_ID+")"
            +");";

    private static final String SQL_CREATE_TABLE_NOTA="CREATE TABLE "+TABELA_NOTA+"("
            +COL_NOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_ONDA_ID_REF+" INTEGER, "
            +"FOREIGN KEY("+COL_ONDA_ID_REF+") REFERENCES " +TABELA_ONDA+"("+COL_ONDA_ID+")"
            +");";

    private static final String SQL_CREATE_TABLE_NOTA_PARCIAL="CREATE TABLE "+TABELA_NOTA_PARCIAL+"("
            +COL_NOTA_PARCIAL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_NOTA_REF+" INTEGER, "
            +COL_NOTA_VALOR+"FLOAT NOT NULL,"
            +"FOREIGN KEY("+COL_NOTA_REF+") REFERENCES " +TABELA_NOTA+"("+COL_NOTA_ID+")"
            +");";

    public CriarBanco( @Nullable Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SURFISTAS);
        db.execSQL(SQL_CREATE_TABLE_BATERIA);
        db.execSQL(SQL_CREATE_TABLE_BATERIA_SURFISTA);
        db.execSQL(SQL_CREATE_TABLE_ONDA);
        db.execSQL(SQL_CREATE_TABLE_NOTA);
        db.execSQL(SQL_CREATE_TABLE_NOTA_PARCIAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_SURFISTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_BATERIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_BATERIA_SURFISTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ONDA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_NOTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_NOTA_PARCIAL);

        onCreate(db);
    }

    public SQLiteDatabase getConexaoDatabase(){
        return  this.getWritableDatabase();
    }
}
