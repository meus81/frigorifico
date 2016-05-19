package modelo.tropa;

import java.io.Serializable;


public class TropaCorralId implements Serializable {

	private int	tropa_id_tropa;

	private int corral_id_corral;

	public int hashCode() {
		return (int) (tropa_id_tropa + corral_id_corral);
	}

	public boolean equals(Object object) {
		if (object instanceof TropaCorralId) {
			TropaCorralId otherId = (TropaCorralId) object;
			return (otherId.tropa_id_tropa == this.tropa_id_tropa) && (otherId.corral_id_corral == this.corral_id_corral);
		}
		return false;
	}
	
}
