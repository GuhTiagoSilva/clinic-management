import React, { useEffect, useState } from 'react';
import { DoctorsResponse } from '../../core/types/Doctor';
import { Link } from 'react-router-dom'
import { makeRequest } from '../../core/utils/request';
import Card from './Card';
import './styles.scss'
import Pagination from '../../core/components/Pagination';
import ButtonIcon from '../../core/components/ButtonIcon';

const Doctor = () => {

    const [doctorResponse, setDoctorResponse] = useState<DoctorsResponse>();
    const [activePage, setActivePage] = useState(0);
    const [isLoading, setIsLoading] = useState(false);

    console.log(doctorResponse);

    useEffect(() => {

        const params = {
            page: activePage,
            linesPerPage: 10
        };

        setIsLoading(true);

        makeRequest({ url: '/doctors', params: params })
            .then((response) => {
                setDoctorResponse(response.data);
            }).finally(() => {
                setIsLoading(false);
            });
    }, [activePage]);

    return (
        <div className="doctors-container">
            <header className="header-container">
                <h1 className="doctor-title">Médicos Cadastrados</h1>

                <Link to="/admin">
                    <ButtonIcon text="Cadastrar Novo Médico" />
                </Link>

            </header>


            <div className="doctors-list">
                {isLoading ? <h1>Carregando</h1> : (
                    doctorResponse?.content.map(doctor => (
                        <Link
                            to={`/products/${doctor.id}`}
                            key={doctor.id}>
                            <Card doctor={doctor} />
                        </Link>
                    )
                    )
                )

                }

            </div>
            {
                doctorResponse?.totalPages &&
                <Pagination
                    totalPages={doctorResponse?.totalPages}
                    activePage={activePage}
                    onChange={page => setActivePage(page)}
                />
            }

        </div>
    );
};

export default Doctor;

