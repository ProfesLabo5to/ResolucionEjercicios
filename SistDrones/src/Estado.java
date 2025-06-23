public enum Estado {
    EN_VUELO(true), EN_OPERATIVO(false), INACTIVO(false), MANTENIMIENTO(false);
    private boolean rastreable;
    Estado(boolean rastreable){
        this.rastreable = rastreable;
    }

    public boolean isRastreable() {
        return rastreable;
    }

    public void setRastreable(boolean rastreable) {
        this.rastreable = rastreable;
    }
}
