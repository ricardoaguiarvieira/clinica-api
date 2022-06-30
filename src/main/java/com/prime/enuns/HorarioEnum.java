package com.prime.enuns;

public enum HorarioEnum {
	
	P0("08:00", 0),
	P1("08:30", 1),
	P2("09:00", 2),
	P3("09:30", 3),
	P4("10:00", 4),
	P5("10:30", 5),
	P6("11:00", 6),
	P7("11:30", 7),
	P8("12:00", 8),
	
	P9("13:30", 9),
	P10("14:00", 10),
	P11("14:30", 11),
	P12("15:00", 12),
	P13("15:30", 13),
	P14("16:00", 14),
	P15("16:30", 15),
	P16("17:00", 16),
	P17("17:30", 17),
	P18("18:00", 18),
	DEFAULT("00:00", 99);
	
	private String hora;
	private int posicao;
	
	private HorarioEnum(String hora, int posicao) {
		this.hora = hora;
		this.posicao = posicao;
	}
	
	public int getPosicao() {
		return this.posicao;
	}
	
	public String getHora() {
		return this.hora;
	}
	
	public static HorarioEnum fromValue(String valor) {
		for (HorarioEnum horario : HorarioEnum.values()) {
            if (horario.getHora().equalsIgnoreCase(valor)) {
                return horario;
            }
        }
		return DEFAULT;
	}
	
}
