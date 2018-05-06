#ifndef ARCHIVO_HEADER_H
#define ARCHIVO_HEADER_H	

#define BUFF 2000 

#define FLAG_O O_CREAT|O_APPEND|O_RDWR 
#define MODO_O S_IRWXU
//"Interfaz":"usoComun"
typedef struct archivo
{
	int fd;
	int leid;
	int esct;
	char cont[BUFF];
	char *nomb;
  char lee[20];
}archivo_t;



int cortar_npartesarchivo(char *entrada, int partes, char *salida);
int cortar_stamanio(char *ientrada,int npartes,char *osalida);

#endif
	