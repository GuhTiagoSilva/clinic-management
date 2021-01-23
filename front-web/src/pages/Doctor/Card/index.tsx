import React from 'react';
import './styles.scss'
import { Doctor } from '../../../core/types/Doctor';

type Props = {
    doctor: Doctor;
}

const Card = ({ doctor }: Props) => {
    return (
        <div className="card-base border-radius-10 doctor-card">
            <div className="doctor-info">
                <h6 className="doctor-name">
                    {doctor.name}
                </h6>
                <h5 className="doctor-informations">
                    <ul>
                        <li>{doctor.address} </li>
                        <li>{doctor.cellphoneNumber} </li>
                        <li>{doctor.phoneNumber} </li>
                    </ul>

                </h5>
            </div>
        </div>
    );
};

export default Card;