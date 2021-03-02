package sv.edu.udb.empleados;

import android.os.Parcel;
import android.os.Parcelable;

public class Empleado implements Parcelable {
    public String Nombre;
    public String Apellido;

    public Integer Horas;
    public double SueldoBase;
    public double ISSS;
    public double AFP;
    public double RENTA;
    public double Sueldo_Liquido;

    public Empleado(String nombre, String apellido, int horas) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Horas = horas;
    }


    protected Empleado(Parcel in) {
        Nombre = in.readString();
        Apellido = in.readString();

        if (in.readByte() == 0) {
            Horas = null;
        } else {
            Horas = in.readInt();
        }
        SueldoBase = in.readDouble();
        ISSS = in.readDouble();
        AFP = in.readDouble();
        RENTA = in.readDouble();
        Sueldo_Liquido = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeString(Apellido);

        if (Horas == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Horas);
        }
        dest.writeDouble(SueldoBase);
        dest.writeDouble(ISSS);
        dest.writeDouble(AFP);
        dest.writeDouble(RENTA);
        dest.writeDouble(Sueldo_Liquido);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Empleado> CREATOR = new Creator<Empleado>() {
        @Override
        public Empleado createFromParcel(Parcel in) {
            return new Empleado(in);
        }

        @Override
        public Empleado[] newArray(int size) {
            return new Empleado[size];
        }
    };

    public double seldom_liquid()
    {
        this.Sueldo_Liquido = (SueldoBase-ISSS-RENTA-AFP);
        return (SueldoBase-ISSS-RENTA-AFP);
    }

    public void setSueldoBase(int horas) {
        this.SueldoBase =  CalcularSueldo(horas);
    }

    public void setISSS(int horas) {
        this.ISSS = desc_ISSS();
    }
    public void setAFP(int horas) {
        this.AFP = desc_AFP();
    }
    public void setRENTA(int horas) {
        this.RENTA = desc_RENTA();
    }

    public double CalcularSueldo(int horas) {
        double sueldo_base = 8.5;
            return (sueldo_base * horas);
    }



    public double desc_ISSS() {
        double isss=0.0;
        isss = SueldoBase* 0.02;
        return  isss;
    }

    public double desc_AFP() {
        double afp=0.0;
        afp = SueldoBase* 0.03;
        return  afp;
    }
    public double desc_RENTA() {
        double renta=0.0;
        renta = SueldoBase* 0.04;
        return  renta;
    }




}
