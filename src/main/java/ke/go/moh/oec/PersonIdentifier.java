/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is OpenEMRConnect.
 *
 * The Initial Developer of the Original Code is International Training &
 * Education Center for Health (I-TECH) <http://www.go2itech.org/>
 *
 * Portions created by the Initial Developer are Copyright (C) 2011
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * ***** END LICENSE BLOCK ***** */
package ke.go.moh.oec;

/**
 * An identifier that has been assigned to a person by one of the systems
 * using OpenEMRConnect.
 * <p>
 * A person may be assigned one or more identifiers. A person may also be assigned
 * no identifier. For example, a person when they first visits a clinic
 * may be identified and entered into a person index database, but they may
 * not yet been registered by that clinic and assigned a patient identifier.
 *
 * @author Jim Grace
 */
public class PersonIdentifier {

	public enum Type {

		patientRegistryId("Patient Registry ID"),
		masterPatientRegistryId("Master Patient Registry ID"),
		cccUniqueId("CCC Unique ID"),
		cccLocalId("CCC Local ID"),
		kisumuHdssId("Kisumu HDSS ID"),
		TELEPHONE_NO("Telephone No"),
		NHIF_NO("NHIF No"),
		NATIONAL_ID("National ID"),
		HUDUMA_NO("Huduma No"),
		PASSPORT_NO("Passport No"),
		BIRTH_CERTIFICATE_NO("Birth Certificate No"),
		BIRTH_NOTIFICATION_NO("Birth Notification No"),
		ALIEN_ID("Alien ID"),
		NEMIS_ID("NEMIS ID");

		private String name;

		Type(String name) {
			this.name = name;
		}
	}

	/**
	 * The type of person identifier.
	 */
	private Type identifierType;
	/**
	 * The value of the person identifier, for example "12345-67890".
	 */
	private String identifier;

	public PersonIdentifier() {
	}

	public PersonIdentifier(Type identifierType, String identifier) {
		this.identifierType = identifierType;
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Type getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(Type identifierType) {
		this.identifierType = identifierType;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PersonIdentifier other = (PersonIdentifier) obj;
		if (this.identifierType != other.identifierType) {
			return false;
		}
		if ((this.identifier == null) ? (other.identifier != null) : !this.identifier.equalsIgnoreCase(other.identifier)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + (this.identifierType != null ? this.identifierType.hashCode() : 0);
		hash = 79 * hash + (this.identifier != null ? this.identifier.hashCode() : 0);
		return hash;
	}
}
